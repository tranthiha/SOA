class CreateBookBorrows < ActiveRecord::Migration[5.1]
  def change
    create_table :book_borrows do |t|
      t.references :book, index: true, foreign_key: true
      t.references :user, index: true, foreign_key: true

      t.timestamps
    end
  end
end
