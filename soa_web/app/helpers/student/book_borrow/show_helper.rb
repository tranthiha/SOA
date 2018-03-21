module Student::BookBorrow::ShowHelper
  def process

  end

  def generate_status
    @status = {
      :code => Settings.code.success,
      :message => "",
      :data    => ,
    }
  end
end
