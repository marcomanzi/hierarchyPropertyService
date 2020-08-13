(ns domain)

(defn node
  [name level]
  {:name name :level level})

(defn hierarchy
  [name nodes]
  {:name name
   :nodes nodes})

(defn relation-between-nodes
  [a-name a-id b-name b-id]
  {:a a-name :a-id a-id
   :b b-name :b-id b-id})