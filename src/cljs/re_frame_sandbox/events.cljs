(ns re-frame-sandbox.events
  (:require
   [re-frame.core :as rf]
   [re-frame-sandbox.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(rf/reg-event-db
  :change-name
  (fn-traced [db [_ name]]
    (-> db
      (assoc :name name)
      (assoc :name-field ""))))

(rf/reg-event-db
  :change-name-field
  (fn-traced [db [_ name]]
    (assoc db :name-field name)))