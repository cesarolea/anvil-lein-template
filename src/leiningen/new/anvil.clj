(ns leiningen.new.anvil
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "anvil"))

(defn anvil
  "Creates a ClojureScript project with optional Docker support"
  ([name & opts]
   (main/info "Generating a new anvil project")
   (let [data {:name name
               :sanitized (name-to-path name)}
         opts (into #{} opts)
         base [["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
               ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
               ["env/dev/clj/user.clj" (render "user.clj" data)]
               ["figwheel-main.edn" (render "figwheel-main.edn" data)]
               ["dev.cljs.edn" (render "dev.cljs.edn" data)]
               ["prod.cljs.edn" (render "prod.cljs.edn" data)]
               ["resources/public/index.html" (render "index.html" data)]
               ["project.clj" (render "project.clj" data)]
               [".gitignore" (render "gitignore" data)]]
         docker [["Dockerfile" (render "Dockerfile" data)]
                 ["docker-compose.yml" (render "docker-compose.yml" data)]]]

     (apply ->files data
            (cond
              (contains? opts "+docker") (concat base docker)
              :else base))))
  ([name]
   (anvil name nil)))
