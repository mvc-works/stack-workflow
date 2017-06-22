
(ns app.render
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [app.comp.container :refer [comp-container]]
            [app.schema :as schema]))

(def base-info
  {:title "Stack Workflow",
   :icon "http://logo.mvc-works.org/mvc.png",
   :ssr nil,
   :inner-html nil})

(defn generate-empty-html []
  (make-page "" (merge base-info {:styles [], :scripts ["/main.js" "/browser/main.js"]})))

(defn generate-html []
  (let [tree (comp-container schema/store)
        html-content (make-string tree)
        manifest (.parse js/JSON (slurp "dist/manifest.json"))
        resources (merge
                   base-info
                   {:styles [(aget manifest "main.css")],
                    :scripts [(aget manifest "vendor.js") (aget manifest "main.js")]})]
    (make-page html-content resources)))

(defn main! []
  (if (= js/process.env.env "dev")
    (spit "target/index.html" (generate-empty-html))
    (spit "dist/index.html" (generate-html))))
