(ns projectname.home.views
  (:require [re-frame.core :as rf]
            [edd.i18n :refer [tr]]
            [projectname.home.subs :as subs]
            [projectname.home.events :as events]

            ["@mui/material/Grid" :default Grid]))

(defn main-panel
  [classes]
  [:> Grid {:container true
            :item      true}
   [:> Grid {:item true
             :xs   12}
    [:h2
     {:class-name (:page classes)
      :on-click   #(rf/dispatch [::events/click])}
     @(rf/subscribe [::subs/name])]]
   [:> Grid {:item true
             :xs   12}
    @(rf/subscribe [::subs/clicks])
    [:h4
     (tr :welcome-home)]]
   (into [:> Grid {:item      true
                   :container true
                   :xs        12}]
         (mapv
           (fn [i]
             [:> Grid {:item true}
              (:first-name i)])
           @(rf/subscribe [::subs/items])))])







