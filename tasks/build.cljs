
(require '[lumo.build.api :as b])

(b/build "src"
  {:main 'client.main
   :output-to "main.js"
   :optimizations :advanced
   :compiler-options {:language-in :ecmascript5
                      :pseudo-names true
                      :static-fns true
                      :parallel-build true
                      :optimize-constants true
                      :source-map true}
   :target :nodejs})
