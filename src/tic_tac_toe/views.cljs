(ns tic-tac-toe.views
  (:require
   [re-frame.core :as re-frame]
   [tic-tac-toe.styles :as styles]
   [tic-tac-toe.subs :as subs]
   ))

(defn cell [position]
  (let [value @(re-frame/subscribe [:cell-value position])]
    [:button {:style {:width "100%" :height "100%"}
              :on-click #(re-frame/dispatch [:update-cell position])}
     [:h1 value]]
    ))

(defn board []
(let [winner @(re-frame/subscribe [:winner])]
  [:<>
   (if (not= winner nil)
     [:div {:class (styles/winner)} [:h1 {:style {:color "white"}} "Winner is " (first winner)]])
   [:div {:class (styles/grid)}
    [:div {:class (styles/one)} [cell "A1"]]
    [:div {:class (styles/two)} [cell "A2"]]
    [:div {:class (styles/three)} [cell "A3"]]
    [:div {:class (styles/four)} [cell "B1"]]
    [:div {:class (styles/five)} [cell "B2"]]
    [:div {:class (styles/six)} [cell "B3"]]
    [:div {:class (styles/seven)} [cell "C1"]]
    [:div {:class (styles/eight)} [cell "C2"]]
    [:div {:class (styles/nine)} [cell "C3"]]
    (if (not= winner nil)
      [:div {:class (styles/line (second winner) (last winner))} ]
      )
    [:div [:button {:on-click #(re-frame/dispatch [:new-game])} "New Game"]]
    ]]
  ))


(defn main-panel []
    [:<>
     [:div {:style {:text-align "center"}}[:h1 "Tic-Tac-Toe"]]
     [board]]
    )
