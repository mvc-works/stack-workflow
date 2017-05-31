
(set-env!
  :resource-paths #{"src"}
  :dependencies '[[org.clojure/clojure       "1.8.0"       :scope "provided"]
                  [org.clojure/clojurescript "1.9.562"     :scope "provided"]
                  [mvc-works/hsl             "0.1.2"]
                  [respo/ui                  "0.1.9"]
                  [respo                     "0.4.2"]])

(def +version+ "0.1.0")

(deftask build []
  (comp
    (pom :project     'mvc-works/stack-workflow
         :version     +version+
         :description "Workflow"
         :url         "https://github.com/mvc-works/stack-workflow"
         :scm         {:url "https://github.com/mvc-works/stack-workflow"}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (install)
    (target)))

(deftask deploy []
  (set-env!
    :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"}]))
  (comp
    (build)
    (push :repo "clojars" :gpg-sign (not (.endsWith +version+ "-SNAPSHOT")))))
