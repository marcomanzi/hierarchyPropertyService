(ns service-test
  (:require [clojure.test :refer :all]
            [service :refer :all]))

(deftest create-nodes-from-list-test
  (is (= [{:name "Root" :level 0} {:name "User" :level 1}]
         (create-nodes-from-list ["Root" "User"]))))

(deftest handle-hierarchy-test
  (is (= {:name "Test"
          :nodes [{:name "Root" :level 0}
                   {:name "User" :level 1}]}
         (create-hierarchy "Test" ["Root" "User"])))
  (is (= {:name "Test"
          :nodes [{:name "Root" :level 0}
                   {:name "User" :level 1}]}
         (remove-hierarchy "Test")))
  (is (nil?
         (find-hierarchy "Test"))))

(deftest create-relation-in-hierarchy
  (create-hierarchy "WebSite" ["Root" "User Group" "User"])
  ;(create-relation-in-hierarchy ["User" 1 "User Group" 1])
  ;(is (= [(node "Root" 0) {:name "User Group" :level 1 :id 1}] (get-related-nodes-in-hierachy "User" 1)))
  (is true))

(deftest handle-property-in-hierarchy
  (create-hierarchy "WebSite" ["Root" "User"])
  (is (= 1 1)))