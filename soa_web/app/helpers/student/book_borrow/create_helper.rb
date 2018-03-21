module Student::BookBorrow::CreateHelper
  def process
    pre_validation

    create_book_borrow

    generate_status
  end

  def create_book_borrow
    BookBorrow.transaction do
      BookBorrow.create(@params)

      @book.update_attributes(quantity_in_stock: @book.quantity_in_stock - 1)
    end
  end

  def pre_validation
    if @book.quantity_in_stock <= 2
      raise Exception.new('Lỗi mượn trả sách')
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
