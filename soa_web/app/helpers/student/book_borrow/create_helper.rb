module Student::BookBorrow::CreateHelper
  def process
    create_book_borrow

    generate_status
  end

  def create_book_borrow
    ::BookBorrow.transaction do
      ::BookBorrow.create(
        :user_id => @params[:user_id],
        :book_id => @params[:book_id]
      )

      @book = ::Book.find_by(id: @params[:book_id])
      @book.update_attributes(quantity_in_stock: @book.quantity_in_stock - 1)
    end
  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "Thành công"
    }
  end
end
