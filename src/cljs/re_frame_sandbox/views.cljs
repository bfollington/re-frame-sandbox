(ns re-frame-sandbox.views
  (:require
   [re-frame.core :as rf]
   [re-frame-sandbox.subs :as subs]
   ))

(defn on-name-updated [e] (rf/dispatch [:change-name-field (-> e .-target .-value)]))
(defn on-name-saved [name] (rf/dispatch [:change-name name]))

(defn main-panel []
  (let [name (rf/subscribe [::subs/name])]
    (let [name-input (rf/subscribe [::subs/name-field])]
      [:div
      [:h1 "Hello from " @name]
      [:input
      { :type "text"
        :value @name-input
        :on-change on-name-updated}]
      [:button
        {:on-click (fn [e] (on-name-saved @name-input))}
        "Change Name"]
      ])))