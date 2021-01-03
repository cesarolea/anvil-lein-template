(ns {{#reagent}}^:figwheel-hooks{{/reagent}}{{name}}.core
    {{#reagent}}(:require [reagent.dom :as dom]){{/reagent}})
(js/console.log "{{name}}")

{{#reagent}}
(defn greeting-component []
  [:div "Hello from Reagent!"])

(defn ^:after-load mount-root []
  (dom/render [greeting-component]
              (.getElementById js/document "app")))

(defn ^:export main []
  (mount-root))
{{/reagent}}

{{#reagent}}
(defn say-hello
  []
  (-> js/document
      (.getElementById "app")
      (.-innerHTML)
      (set! "Hello from ClojureScript!")))

(say-hello)
{{/reagent}}

{{#lambda}}
(defn say-hello []
  (js/console.log "Hello World!"))

(defn handler
  "Lambda main entry point"
  [event context callback]
  (do
    (println event)
    (callback nil
              (clj->js {:status 200
                        :body "Hello from ClojureScript in AWS lambda!"
                        :headers {}}))))

(set! (.-exports js/module) #js{:handler handler :hello say-hello})
{{/lambda}}
