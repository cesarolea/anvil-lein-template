(ns {{name}}.core
    {{#reagent}}(:require [reagent.dom :as dom]){{/reagent}})
(js/console.log "{{name}}")

{{#reagent}}
(defn greeting-component []
  [:div "Hello from Reagent!"])

(defn mount-root []
  (dom/render [greeting-component]
              (.getElementById js/document "app")))

(defn ^:export main []
  (mount-root))
{{/reagent}}

{{^reagent}}
(defn say-hello
  []
  (-> js/document
      (.getElementById "app")
      (.-innerHTML)
      (set! "Hello from ClojureScript!")))

(say-hello)
{{/reagent}}
