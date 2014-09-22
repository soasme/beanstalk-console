(ns beanstalk-console.tmpl.home
  (:use [hiccup.page :as page]))

(defn index []
  (page/html5
   [:head
    [:title "Beanstalk Console"]
    [:meta {:charset "utf-8"}]
    [:meta {:name "description" :content "Beanstalk console"}]
    (page/include-css "/resources/lib/bootstrap-3.2.0-dist/css/bootstrap.min.css")
    (page/include-js "/resources/lib/jquery-2.1.1.min.js")
    (page/include-js "/resources/lib/bootstrap-3.2.0-dist/js/bootstrap.min.js")]
   [:body
    [:nav.navbar.navbar-inverse.navbar-fixed-top {:role "nagivation"}
     [:div.container-fuild
      [:div.navbar-header
        [:button.navbar-toggle.collapsed
         {:data-toggle "collapse",
          :data-target "#navbar",
          :aria-expanded false,
          :aria-controls "navbar"}
         [:span.sr-only "Toggle navigation"]
         [:span.icon-bar]
         [:span.icon-bar]
         [:span.icon-bar]]
        [:a.navbar-brand {:href "#"} "Beanstalk Console"]]]]
    [:div.container-fluid
     [:div.row]]]))
