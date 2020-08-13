(ns service
  (:require [persistence :as p]
            [domain :as d]))

(defn create-nodes-from-list
  [ordered-node-names-list]
  (map-indexed #(d/node %2 %1) ordered-node-names-list) )

(defn create-hierarchy
  [name ordered-node-names-list]
  (->> (create-nodes-from-list ordered-node-names-list)
       (d/hierarchy name)
       (p/save-hierarchy)))

(def remove-hierarchy p/remove-hierarchy-by-name)

(def find-hierarchy p/find-hierarchy)