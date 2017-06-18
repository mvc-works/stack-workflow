
(ns app.comp.container
  (:require-macros (respo.macros :refer (defcomp)))
  (:require (hsl.core :refer (hsl))
            (respo-ui.style :as ui)
            (respo.alias :refer (create-comp div span))
            (respo.comp.space :refer (comp-space))
            (respo.comp.text :refer (comp-text))))

(defcomp
 comp-container
 (store)
 (div
  {:style (merge ui/global)}
  (comp-space "8px" nil)
  (div {:style ui/button} (comp-text "Demo" nil))))
