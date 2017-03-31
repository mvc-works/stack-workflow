
(ns client.main
  (:require [respo.core :refer [render! clear-cache! falsify-stage! render-element]]
            [client.comp.container :refer [comp-container]]
            [cljs.reader :refer [read-string]]))

(defn dispatch! [op op-data] )

(defonce ref-store (atom {:states {}}))

(defn render-app! []
  (let [target (.querySelector js/document "#app")]
    (render! (comp-container @ref-store) target dispatch!)))

(def ssr-stages
  (let [ssr-element (.querySelector js/document "#ssr-stages")
        ssr-markup (.getAttribute ssr-element "content")]
    (read-string ssr-markup)))

(defn -main! []
  (enable-console-print!)
  (if (not (empty? ssr-stages))
    (let [target (.querySelector js/document "#app")]
      (falsify-stage!
       target
       (render-element (comp-container @ref-store ssr-stages))
       dispatch!)))
  (render-app!)
  (add-watch ref-store :changes render-app!)
  (println "App started!"))

(defn on-jsload! [] (clear-cache!) (render-app!) (println "Code updated."))

(set! (.-onload js/window) -main!)
