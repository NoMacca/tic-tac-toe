(ns tic-tac-toe.events
  (:require
   [re-frame.core :as re-frame]
   [tic-tac-toe.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(defn toggle [turn]
  (cond
    (= turn "X") "O"
    (= turn "O") "X"
    :else nil))

(re-frame/reg-event-fx
 :update-cell
 (fn [{:keys [db]} [_ pos]]
   (let [cell (keyword pos)
         cell-value (cell db)
         turn (:turn db)]
     (if (= cell-value nil)
       {:db (-> db
            (assoc (keyword pos) turn)
            (assoc :turn (toggle turn)))
        :dispatch [:check-state]}
       ))))

(re-frame/reg-event-db
:check-state
 (fn [db _]
   (let [
         A1 (:A1 db)
         A2 (:A2 db)
         A3 (:A3 db)

         B1 (:B1 db)
         B2 (:B2 db)
         B3 (:B3 db)

         C1 (:C1 db)
         C2 (:C2 db)
         C3 (:C3 db)]
     (cond
       (and A1 (= A1 A2 A3)) (assoc db :winner [A1 "h1" "h"])
       (and B1 (= B1 B2 B3)) (assoc db :winner [B1 "h2" "h"])
       (and C1 (= C1 C2 C3)) (assoc db :winner [C1 "h3" "h"])

       (and A1 (= A1 B1 C1)) (assoc db :winner [A1 "v1" "v"])
       (and A2 (= A2 B2 C2)) (assoc db :winner [A2 "v2" "v"])
       (and A3 (= A3 B3 C3)) (assoc db :winner [A3 "v3" "v"])

       (and A1 (= A1 B2 C3)) (assoc db :winner [A1 "f" "dl"])
       (and A3 (= A3 B2 C1)) (assoc db :winner [A3 "f" "dr"])
       :else db
       ))))

(re-frame/reg-event-db
 :new-game
 (fn [db _ ]
   db/default-db ))
