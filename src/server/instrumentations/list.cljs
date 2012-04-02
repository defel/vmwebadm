(ns server.instrumentations.list
  (:use [server.utils :only [clj->js prn-js clj->json transform-keys]])
  (:require [server.storage :as storage]
            [server.http :as http]))



(def data-map {})

(defn handle [resource request response account]
  (http/write response 200
              {"Content-Type" "application/json"}
              (clj->json
               (get-in @storage/data [:users account :instrumentations]))))