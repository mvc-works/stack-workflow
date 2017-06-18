
(ns app.main
  (:require (respo.core :refer (render! clear-cache! falsify-stage! render-element))
            (app.comp.container :refer (comp-container))
            (cljs.reader :refer (read-string))
            (app.updater.core :refer (updater))))

(defonce *store (atom {:states {}}))

(defn dispatch! [op op-data]
  (let [next-store (updater @*store op op-data)] (reset! *store next-store)))

(def mount-target (.querySelector js/document ".app"))

(defn render-app! [] (render! (comp-container @*store) mount-target dispatch!))

(defn reload! [] (clear-cache!) (render-app!) (println "Code updated."))

(def server-rendered? (some? (js/document.querySelector "meta#server-rendered")))

(defn main! []
  (if server-rendered?
    (falsify-stage! mount-target (render-element (comp-container @*store)) dispatch!))
  (render-app!)
  (add-watch *store :changes render-app!)
  (println "App started."))

(set! (.-onload js/window) main!)
