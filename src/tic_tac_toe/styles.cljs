(ns tic-tac-toe.styles
  (:require-macros
    [garden.def :refer [defcssfn]])
  (:require
    [spade.core   :refer [defglobal defclass]]
    [garden.units :refer [deg px]]
    [garden.color :refer [rgba]]))

;; (defcssfn linear-gradient
;;  ([c1 p1 c2 p2]
;;   [[c1 p1] [c2 p2]])
;;  ([dir c1 p1 c2 p2]
;;   [dir [c1 p1] [c2 p2]]))



(defglobal defaults
  [:body
   {
    ;; :color               :red
    :background-color    :#ddd}])
  ;; (defglobal defaults

  ;;   [:body
  ;;    {:color               :red
  ;;     :background-color    :#ddd
  ;;     :background-image    [(linear-gradient :white (px 2) :transparent (px 2))
  ;;                           (linear-gradient (deg 90) :white (px 2) :transparent (px 2))
  ;;                           (linear-gradient (rgba 255 255 255 0.3) (px 1) :transparent (px 1))
  ;;                           (linear-gradient (deg 90) (rgba 255 255 255 0.3) (px 1) :transparent (px 1))]
  ;;     :background-size     [[(px 100) (px 100)] [(px 100) (px 100)] [(px 20) (px 20)] [(px 20) (px 20)]]
  ;;     :background-position [[(px -2) (px -2)] [(px -2) (px -2)] [(px -1) (px -1)] [(px -1) (px -1)]]}])



  (defclass grid
    []
    {
     :display "grid"
     :grid-template-areas
     "
\"one   two   three\"\n
\"four  five  six\"\n
\"seven eight nine\"
"
     :grid-template-columns "20% 20% 20%" ;;"1fr 1fr 1fr"
     :grid-template-rows "repeat(3, minmax(80px, auto))"
     ;; :align-content "center"
     :justify-content "center"
     ;; :background-color "blue"
     :border-collapse "collapse"
     :gap "1px"
     })

(defclass one
  []
  {
   :grid-area "one"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })

(defclass two
  []
  {
   ;; :border "solid"
   ;; :border-width "1px"
   :grid-area "two"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })
(defclass three
  []
  {
   ;; :border "solid"
   ;; :border-width "1px"
   :grid-area "three"

   :outline "1px solid black"
   :display "flex"
   :justify-content "center"
   :align-items "center"
   })
(defclass four
  []
  {
   ;; :border "solid"
   :grid-area "four"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })
(defclass five
  []
  {
   ;; :border "solid"
   :grid-area "five"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })
(defclass six
  []
  {
   ;; :border "solid"
   :grid-area "six"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })
(defclass seven
  []
  {
   ;; :border "solid"
   :grid-area "seven"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })
(defclass eight
  []
  {
   ;; :border "solid"
   :grid-area "eight"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })
(defclass nine
  []
  {
   ;; :border "solid"
   :grid-area "nine"
   :display "grid"
   :place-items "center"
   :outline "1px solid black"
   })

(defclass winner []
  {

   :background-image "repeating-linear-gradient(to right, blue, red)"
   :text-align "center"}
  )

(defclass diagonal [start]
  {
   :grid-area "one-start/one-start/nine-end/nine-end"
   :background-image (str "linear-gradient(to bottom " start ", transparent 49.5%, black 49.5%, black 50.5%, transparent 50.5%)")
   })

(defclass line [area bg]
{
 :grid-area (cond
              (= area "v1") "one-start/one-start/nine-end/one-end"
              (= area "v2") "one-start/two-start/nine-end/two-end"
              (= area "v3") "one-start/three-start/nine-end/three-end"

              (= area "h1") "one-start/one-start/three-end/three-end"
              (= area "h2") "four-start/four-start/four-end/six-end"
              (= area "h3") "seven-start/seven-start/seven-end/nine-end"

              (= area "f") "one-start/one-start/nine-end/nine-end"
              :else nil
              )

 :background-image (cond
                     (= "v" bg) "linear-gradient(to right, transparent 49.5%, red 49.5%, black 50.5%, transparent 50.5%)"
                     (= "h" bg) "linear-gradient(to bottom, transparent 48.5%, red 48.5%, black 51.5%, transparent 51.5%)";
                     (= "dl" bg) "linear-gradient(to bottom left, transparent 49.5%, red 49.5%, black 50.5%, transparent 50.5%)"
                     (= "dr" bg) "linear-gradient(to bottom right, transparent 49.5%, red 49.5%, black 50.5%, transparent 50.5%)")


 }
  )
