(ns re-frame-sandbox.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::name-field
 (fn [db]
   (:name-field db)))
