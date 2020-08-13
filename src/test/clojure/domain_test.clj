(ns domain-test
  (:require [clojure.test :refer :all]
            [domain :refer :all]))

(deftest hierarchyCreation
  (is (= {:name "TestHierarchy"
          :nodes [{:name "Root"
                   :level 0}
                  {:name "User"
                   :level 1}]}
         (hierarchy "TestHierarchy" [(node "Root" 0) (node "User" 1)] ))))
