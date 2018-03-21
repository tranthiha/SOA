class Api::V1::BookBorrowController < ApplicationController
  before_action :authenticate_request!
  skip_before_action :verify_authenticity_token
  before_action -> {pre_processing}

  include Student::Book::BookHelper

  def create
    render json: @action.status
  end

  def index
    render json: @action.status
  end

  def show
    render json: @action.status
  end

  def destroy
    render json: @action.status
  end
end
