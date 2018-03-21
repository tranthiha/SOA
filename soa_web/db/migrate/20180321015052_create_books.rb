class CreateBooks < ActiveRecord::Migration[5.1]
  def change
    create_table :books do |t|
      t.string :author
      t.string :country
      # t.text :image_link
      t.string :language
      t.string :pages
      t.string :title, null: false
      t.datetime :year
      t.integer :quantity_in_stock, default: 0

      t.timestamps
    end
  end
end
