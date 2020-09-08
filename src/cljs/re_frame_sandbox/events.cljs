(ns re-frame-sandbox.events
  (:require
   [re-frame.core :as re-frame]
   [re-frame-sandbox.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(re-frame/reg-event-db
  :change-name
  (fn-traced [db [_ name]]
    (-> db
      (assoc :name name)
      (assoc :name-field ""))))

(re-frame/reg-event-db
  :change-name-field
  (fn-traced [db [_ name]]
    (assoc db :name-field name)))