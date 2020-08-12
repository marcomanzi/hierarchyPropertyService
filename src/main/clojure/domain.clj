(ns domain)

(defn node
  [name level]
  {:name name :level level})

(defn hierarchy
  [name & nodes]
  {:name name
   :nodes (set nodes)})