(ns server.keys.list
  (:use [server.utils :only [clj->js prn-js clj->json transform-keys]])
  (:require [server.storage :as storage]
            [server.http :as http]))

(defn handle [resource request response account]
  (http/write response 200
              {"Content-Type" "application/json"}
              (clj->json
               {"keys" (get-in @storage/data [:users account :keys])})))