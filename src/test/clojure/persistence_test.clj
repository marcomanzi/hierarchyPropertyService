(ns persistence-test
  (:require [clojure.test :refer :all])
  (:require [persistence :refer :all])
  (:require [domain :refer :all]))

(deftest persistenceForHierarchy
  (is (= {:name "Test"
          :nodes #{{:name "Root" :level 0}
                   {:name "User" :level 1}}}
         (save-hierarchy (hierarchy "Test" (node "Root" 0) (node "User" 1)))))
  (is (= {:name "Test"
          :nodes #{{:name "Root" :level 0}
                   {:name "User" :level 1}}}
         (find-hierarchy "Test" )))
  (is (= {:name "Test"
          :nodes #{{:name "Root" :level 0}
                   {:name "User" :level 2}}}
         (update-hierarchy (hierarchy "Test" (node "Root" 0) (node "User" 2)) )))
  (is (= {:name "Test"
          :nodes #{{:name "Root" :level 0}
                   {:name "User" :level 2}}}
         (find-hierarchy "Test" )))
  (is (= {:name "Test"
          :nodes #{{:name "Root" :level 0}
                   {:name "User" :level 2}}}
         (remove-hierarchy-by-name "Test" )))
  (is (nil? (find-hierarchy "Test" ))))