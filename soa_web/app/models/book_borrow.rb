class BookBorrow < ApplicationRecord
  belongs_to :book
  belongs_to :student
end
