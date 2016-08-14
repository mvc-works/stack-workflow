
(ns stack-workflow.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [stack-workflow.style.widget :as widget]
            [stack-workflow.comp.button :refer [comp-button]]))

(defn render []
  (fn [state mutate!]
    (div
      {:style (merge widget/global)}
      (span {:attrs {:inner-text "Container"}})
      (comp-space "8px" nil)
      (div {:style widget/button} (comp-text "add" nil))
      (comp-space "8px" nil)
      (comp-button))))

(def comp-container (create-comp :container render))
