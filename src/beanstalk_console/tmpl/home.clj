(ns beanstalk-console.tmpl.home
  (:use [hiccup.page :as page]))

(defn index []
  (page/html5
   [:head
    [:title "Beanstalk Console"]
    [:meta {:charset "utf-8"}]
    [:meta {:name "description" :content "Beanstalk console"}]
    (page/include-css "/resources/js/lib/bootstrap/dist/css/bootstrap.min.css")
    (page/include-js "/resources/js/lib/jquery/dist/jquery.min.js"
                     "/resources/js/lib/bootstrap/dist/js/bootstrap.min.js"
                     "/resources/js/lib/underscore/underscore-min.js"
                     "/resources/js/lib/backbone/backbone.js"
                     "/resources/dist/js/main.js")]
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
