(ns tic-tac-toe.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))


(re-frame/reg-sub
 :cell-value
 (fn [db [_ pos]]
   ((keyword pos) db)))

(re-frame/reg-sub
 :winner
 (fn [db _]
   (:winner db)))
