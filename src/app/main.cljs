
(ns app.main
  (:require [respo.core :refer [render! clear-cache! falsify-stage! render-element]]
            [respo.cursor :refer [mutate]]
            [app.comp.container :refer [comp-container]]
            [cljs.reader :refer [read-string]]
            [app.updater.core :refer [updater]]
            [app.schema :as schema]))

(defonce *store (atom schema/store))

(defn dispatch! [op op-data]
  (let [next-store (if (= op :states)
                     (update @*store :states (mutate op-data))
                     (updater @*store op op-data))]
    (reset! *store next-store)))

(def mount-target (.querySelector js/document ".app"))

(defn render-app! [renderer] (renderer mount-target (comp-container @*store) dispatch!))

(defn reload! [] (clear-cache!) (render-app! render!) (println "Code updated."))

(def server-rendered? (some? (js/document.querySelector "meta.respo-ssr")))

(defn main! []
  (if server-rendered? (render-app! falsify-stage!))
  (render-app! render!)
  (add-watch *store :changes render-app!)
  (println "App started."))

(set! (.-onload js/window) main!)
