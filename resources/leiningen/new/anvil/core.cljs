(ns {{name}}.core)
(js/console.log "{{name}}")

(defn say-hello
  []
  (-> js/document
      (.getElementById "app")
      (.-innerHTML)
      (set! "Hello from ClojureScript!")))

(say-hello)
