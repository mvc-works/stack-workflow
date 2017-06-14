
(set-env!
  :resource-paths #{"src"}
  :dependencies '[])

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
