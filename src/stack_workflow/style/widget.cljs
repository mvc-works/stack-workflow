
(ns stack-workflow.style.widget
  (:require [hsl.core :refer [hsl]]))

(def global {:font-family "Verdana"})

(def button
 {:line-height 2,
  :color "white",
  :background-color (hsl 200 90 60),
  :padding "0 8px",
  :display "inline-block"})
