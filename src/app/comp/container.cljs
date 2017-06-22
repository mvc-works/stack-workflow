
(ns app.comp.container
  (:require-macros [respo.macros :refer [defcomp <> div span]])
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.core :refer [create-comp]]
            [respo.comp.space :refer [=<]]))

(defcomp
 comp-container
 (store)
 (div
  {:style (merge ui/global)}
  (=< "8px" nil)
  (div {:style ui/button} (<> span "Demo" nil))))
