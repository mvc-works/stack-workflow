
(ns client.main
  (:require [respo.core
             :refer
             [render! clear-cache! falsify-stage! render-element gc-states!]]
            [client.comp.container :refer [comp-container]]
            [cljs.reader :refer [read-string]]))

(defn dispatch! [op op-data] )

(defonce ref-store (atom {}))

(defonce ref-states (atom {}))

(defn render-app! []
  (let [target (.querySelector js/document "#app")]
    (render! (comp-container @ref-store) target dispatch! ref-states)))

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
       (render-element (comp-container @ref-store ssr-stages) ref-states)
       dispatch!)))
  (render-app!)
  (add-watch ref-store :gc (fn [] (gc-states! ref-states)))
  (add-watch ref-store :changes render-app!)
  (add-watch ref-states :changes render-app!)
  (println "App started!"))

(defn on-jsload! [] (clear-cache!) (render-app!) (println "Code updated."))

(set! (.-onload js/window) -main!)
