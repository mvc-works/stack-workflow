
(ns app.main
  (:require [respo.core :refer [render! clear-cache! falsify-stage! render-element]]
            [app.comp.container :refer [comp-container]]
            [cljs.reader :refer [read-string]]
            [app.updater.core :refer [updater]]))

(defonce ref-store (atom {:states {}}))

(defn dispatch! [op op-data]
  (let [next-store (updater @ref-store op op-data)] (reset! ref-store next-store)))

(defn render-app! []
  (let [target (.querySelector js/document "#app")]
    (render! (comp-container @ref-store) target dispatch!)))

(def server-rendered? (some? (js/document.querySelector "meta#server-rendered")))

(defn -main! []
  (enable-console-print!)
  (if server-rendered?
    (let [target (.querySelector js/document "#app")]
      (falsify-stage! target (render-element (comp-container @ref-store)) dispatch!)))
  (render-app!)
  (add-watch ref-store :changes render-app!)
  (println "App started."))

(defn on-jsload! [] (clear-cache!) (render-app!) (println "Code updated."))

(set! (.-onload js/window) -main!)
