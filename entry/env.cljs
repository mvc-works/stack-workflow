
(ns client.env
  (:require [cljs.reader :refer [read-string]]))

(def fs (js/require "fs"))
(def path (js/require "path"))


(def pkg (js/require "../package.json"))
(def config (read-string (fs.readFileSync "shadow.edn" "utf8")))

(def target (if (= js/process.env.target "nodejs") :nodejs :web))

(println "Targeting" target)

(aset pkg "shadow-cljs" (clj->js config))

(fs.writeFileSync "package.json" (js/JSON.stringify pkg nil 2))
(println "Rewrote package.json")
