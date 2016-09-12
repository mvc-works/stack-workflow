
(ns stack-workflow.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.alias :refer [create-comp div span]]
            [respo.comp.space :refer [comp-space]]
            [respo.comp.text :refer [comp-text]]
            [stack-workflow.style.widget :as widget]
            [stack-workflow.comp.button :refer [comp-button]]))

(defn render []
  (fn [state mutate!]
    (div
      {:style (merge ui/global)}
      (comp-space "8px" nil)
      (div {:style ui/button} (comp-text "demo" nil)))))

(def comp-container (create-comp :container render))
