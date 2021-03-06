(ns status-im.utils.mixpanel-events)
;; This file is supposed to be edited by Chad.
;; Chad loves mixpanel. When Chad was a child he dreamed of being a mixpanel tamer.

;; To add a new event definition, add a new map to this vector
;; :label is a free string that is displayed in mixpanel
;; :trigger is the re-frame style event that when matched will generate the emission of a mixpanel event
;; :properties is a map of key / value pair that will be added to the mixpanel event to provide more context
(def events
  [;; Account creation

   {:label   "Account created"
    :trigger [:account-finalized]}
   {:label   "Account restored"
    :trigger [:account-recovered]}

   ;; Account lifecycle

   {:label   "Login"
    :trigger [:initialize-account]}

   {:label   "Logout"
    :trigger [:navigate-to :accounts]}

   ; Push notification settings

   {:label      "Tap"
    :trigger    [:request-notifications-granted]
    :properties {:target :granted-push-notifications}}

   {:label      "Tap"
    :trigger    [:request-notifications-denied]
    :properties {:target :denied-push-notifications}}

   ;; Tab navigation

   {:label      "Tap"
    :trigger    [:navigate-to-clean :home]
    :properties {:target :home}}
   {:label      "Tap"
    :trigger    [:navigate-to-tab :home]
    :properties {:target :home}}
   {:label      "Tap"
    :trigger    [:navigate-to-tab :my-profile]
    :properties {:target :my-profile}}
   {:label      "Tap"
    :trigger    [:navigate-to-clean :wallet]
    :properties {:target :wallet}}
   {:label      "Tap"
    :trigger    [:navigate-to-tab :wallet]
    :properties {:target :wallet}}

   ;; New
   {:label      "Tap"
    :trigger    [:navigate-to :new]
    :properties {:target :new}}
   {:label      "Tap"
    :trigger    [:navigate-to :new-chat]
    :properties {:target :new-chat}}
   {:label      "Tap"
    :trigger    [:scan-qr-code]
    :properties {:target :new-chat-qr-code}}
   {:label      "Tap"
    :trigger    [:show-profile]
    :properties {:target :show-profile}}
   {:label      "Tap"
    :trigger    [:open-contact-toggle-list]
    :properties {:target :new-group-chat}}
   {:label      "Tap"
    :trigger    [:navigate-to :new-public-chat]
    :properties {:target :new-public-chat}}
   {:label      "Tap"
    :trigger    [:navigate-to :open-dapp]
    :properties {:target :open-dapp}}
   {:label      "Tap"
    :trigger    [:navigate-to :dapp-description]
    :properties {:target :open-dapp-description}}
   {:label      "Tap"
    :trigger    [:open-dapp-in-browser]
    :properties {:target :open-selected-dapp}}
   {:label      "Tap"
    :trigger    [:navigate-to :new-group]
    :properties {:target :start-group-chat-next}}
   {:label      "Tap"
    :trigger    [:create-new-public-chat]
    :properties {:target :create-public-chat}}
   {:label      "Tap"
    :trigger    [:navigate-to :new-public-chat]
    :properties {:target :join-public-chat}}

   ;; Chat

   {:label      "Tap"
    :trigger    [:navigate-to-chat]
    :properties {:target :open-existing-chat}}
   {:label      "Tap"
    :trigger    [:navigate-to :browser]
    :properties {:target :open-existing-dapp}}
   {:label      "Tap"
    :trigger    [:start-chat]
    :properties {:target :start-chat}}
   {:label      "Tap"
    :trigger    [:send-current-message]
    :properties {:target :send-current-message}}

   ;; Wallet
   {:label      "Tap"
    :trigger    [:navigate-to :wallet-send-transaction]
    :properties {:target :wallet-send-transaction}}
   {:label      "Tap"
    :trigger    [:navigate-to :wallet-request-transaction]
    :properties {:target :wallet-request-transaction}}
   {:label      "Tap"
    :trigger    [:navigate-to :transactions-history]
    :properties {:target :transactions-history}}
   {:label      "Tap"
    :trigger    [:navigate-to :recent-recipients]
    :properties {:target :select-recipient
                 :type   :recent-recipients}}
   {:label      "Tap"
    :trigger    [:navigate-to :recipient-qr-code]
    :properties {:target :select-recipient
                 :type   :recipient-qr-code}}
   {:label      "Tap"
    :trigger    [:navigate-to :contact-code]
    :properties {:target :select-recipient
                 :type   :contact-code}}
   {:label      "Tap"
    :trigger    [:navigate-to :wallet-send-assets]
    :properties {:target :wallet-send-assets}}
   {:label      "Tap"
    :trigger    [:wallet.send/toggle-advanced]
    :properties {:target :wallet-advanced}}
   {:label      "Tap"
    :trigger    [:wallet.send/set-signing?]
    :properties {:target :wallet-open-sign-transaction}}
   {:label      "Tap"
    :trigger    [:wallet/sign-transaction]
    :properties {:target :wallet-sign-transaction}}
   {:label      "Tap"
    :trigger    [:wallet/sign-transaction-modal]
    :properties {:target :dapp-sign-transaction}}
   {:label      "Tap"
    :trigger    [:navigate-to-clean :wallet]
    :properties {:target :wallet-got-it}}
   {:label      "Tap"
    :trigger    [:send-transaction-message]
    :properties {:target :wallet-transaction-sent}}
   {:label      "Tap"
    :trigger    [:navigate-to :collectibles-list]
    :properties {:target :collectibles-list}}
   {:label      "Tap"
    :trigger    [:open-collectible-in-browser]
    :properties {:target :open-collectible-in-browser}}

   ;;Profile
   {:label      "Tap"
    :trigger    [:my-profile/start-editing-profile]
    :properties {:target :edit-profile}}
   {:label      "Tap"
    :trigger    [:my-profile/update-picture]
    :properties {:target :edit-image
                 :type   :gallery}}
   {:label      "Tap"
    :trigger    [:navigate-to :profile-photo-capture]
    :properties {:target :edit-image
                 :type   :capture}}
   {:label      "Tap"
    :trigger    [:navigate-to :profile-qr-viewer]
    :properties {:target :share-contact-code}}
   {:label      "Tap"
    :trigger    [:set :my-profile/advanced? true]
    :properties {:target :profile-advanced
                 :type   :open}}
   {:label      "Tap"
    :trigger    [:set :my-profile/advanced? false]
    :properties {:target :profile-advanced
                 :type   :closed}}
   {:label      "Tap"
    :trigger    [:switch-dev-mode true]
    :properties {:target :profile-dev-mode
                 :type   :on}}
   {:label      "Tap"
    :trigger    [:switch-dev-mode false]
    :properties {:target :profile-dev-mode
                 :type   :off}}
   {:label      "Tap"
    :trigger    [:navigate-to :backup-seed]
    :properties {:target :backup-your-seed-phrase}}
   {:label      "Tap"
    :trigger    [:set-in [:my-profile/seed :step] :12-words]
    :properties {:target :seed-phrase
                 :type   :welcome-ok}}
   {:label      "Tap"
    :trigger    [:my-profile/enter-two-random-words]
    :properties {:target :seed-phrase
                 :type   :step1-next}}
   {:label      "Tap"
    :trigger    [:my-profile/set-step :second-word]
    :properties {:target :seed-phrase
                 :type   :step2-next}}
   {:label      "Tap"
    :trigger    [:my-profile/finish]
    :properties {:target :seed-phrase
                 :type   :step3-done}}])
