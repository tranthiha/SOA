Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  root "static_pages#home"

  namespace :api, defaults: { format: :json } do
    namespace :v1 do
      namespace :student do
        resource :book_borrow, only: [:create, :index, :destroy]
        resource :books, only: [:index, :show]
      end

      namespace :librarian do
        resource :book_management, only: [:create, :index, :show, :update, :destroy]
      end
    end
  end

  get "*path", :to => "static_pages#home"
end
