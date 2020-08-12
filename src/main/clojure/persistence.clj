(ns persistence)

(def hierarchy-store (atom []))
(defn save-hierarchy
  [hierarchy]
  (swap! hierarchy-store conj hierarchy)
  hierarchy)

(defn remove-hierarchy
  [hierarchy]
  (swap! hierarchy-store #(remove (fn [it] (= hierarchy it)) %))
  hierarchy)

(defn find-hierarchy
  [name]
  (first (filter #(= (:name %) name) @hierarchy-store)))

(def remove-hierarchy-by-name (comp remove-hierarchy find-hierarchy))

(defn update-hierarchy
  [hierarchy]
  (remove-hierarchy-by-name (:name hierarchy))
  (save-hierarchy hierarchy)
  hierarchy)