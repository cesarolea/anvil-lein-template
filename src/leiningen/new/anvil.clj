(ns leiningen.new.anvil
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "anvil"))

(defn anvil
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' anvil project.")
    (->files data
             ["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["env/dev/clj/user.clj" (render "user.clj" data)]
             ["figwheel-main.edn" (render "figwheel-main.edn" data)]
             ["dev.cljs.edn" (render "dev.cljs.edn" data)]
             ["prod.cljs.edn" (render "prod.cljs.edn" data)]
             ["resources/public/index.html" (render "index.html" data)]
             ["project.clj" (render "project.clj" data)])))
