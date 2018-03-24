module Student::BookBorrow::CreateHelper
  def process
    create_book_borrow

    generate_status
  end

  def create_book_borrow
    ::BookBorrow.transaction do
      ::BookBorrow.create(@params)

      ::Book.find_by(id: @params[:book_id])
        .update_attributes(quantity_in_stock: @book.quantity_in_stock - 1)
    end
  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "Thành công"
    }
  end
end
