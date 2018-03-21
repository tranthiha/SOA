module Student::BookBorrow::ShowHelper
  def process
    get_book_borrow

    generate_status
  end

  def get_book_borrow
    BookBorrow.find_by(id: @params[:id])
  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "",
      :data    => ,
    }
  end
end
