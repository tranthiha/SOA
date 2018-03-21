module Student::BookBorrow::DestroyHelper
  def process
    destroy_book_borrow

    generate_status
  end

  def destroy_book_borrow
    BookBorrow.transaction do
      BookBorrow.find_by(id: @params[:id]).destroy

      @book.update_attributes(quantity_in_stock: @book.quantity_in_stock + 1)
    end
  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "",
      :data    => ,
    }
  end
end
