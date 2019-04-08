(ns user
  (:require [figwheel.main.api :as fw-api]
            [mount.core :as mount]
            [{{name}}.core]))

(defn start [] (mount/start))

(defn stop [] (mount/stop-except))
