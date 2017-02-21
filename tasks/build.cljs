
(require '[lumo.build.api :as b])

(b/build "src"
  {:main 'client.main
   :output-to "main.js"
   :optimizations :none})
